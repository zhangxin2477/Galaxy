var express = require('express');
var request = require('request');
var Service = require('node-zookeeper-dubbo');

var opt = {
    application: {name: 'demon-provider'},
    register: '192.168.3.64:20880',
    dubboVer: '2.6.1',
    root: 'dubbo',
    dependencies: {
        DemonService: {
            interface: 'com.galaxy.demon.service.DemonService',
            version: 'LATEST',
            timeout: 6000,
            group: 'demon',
            methodSignature: {
                getOrg: function (id) {
                    [{'$class': 'java.lang.Long', '$': id}]
                }
            }
        }
    }
}
opt.java = require('js-to-java');
var service = new Service(opt);
var getUserObj = {
    $class: 'com.galaxy.demon.service.DemonService',
    $: {
        a: 1,
        b: 'getOrg',
        c: {$class: 'java.lang.Long', $: 1}
    }
};

var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
    res.render('index', {title: 'Express'});
});

router.get('/getOrg', function (req, res) {
    service.DemonService.getOrg(1)
        .then(function (data) {
            res.send(data);
        })
        .catch(function (err) {
            res.send(err);
        });
});

module.exports = router;
