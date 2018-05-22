var express = require('express');
var http = require('http');

var router = express.Router();

var options = {
    hostname: 'localhost',
    port: 8080,
    path: '/',
    method: 'GET'
};

/* GET home page. */
router.get('/', (req, res, next) => {
    var httpReq = http.request(options, (httpRes) => {
        console.log('STATUS:' + httpRes.statusCode);
        console.log('HEADERS:' + JSON.stringify(httpRes.headers));
        httpRes.setEncoding('utf-8');
        let rawData = 'body=';
        httpRes.on('data', (chunk) => {
            rawData += chunk;
            console.info('BODY:' + rawData)
        });
        httpRes.on('end', () => {
            res.render('index', {title: 'Express', body: rawData});
            console.log('Response End....');
        });
    });

    httpReq.on('error', (err) => {
        console.error(err);
    });
    httpReq.end();
});

module.exports = router;
