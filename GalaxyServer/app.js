var express = require('express');//加载express模块
var path = require('path');
//这就是一个解析Cookie的工具。通过req.cookies可以取到传过来的cookie，并把它们转成对象。
var cookieParser = require('cookie-parser');
//在控制台中，显示req请求的信息
var logger = require('morgan');
var bodyParser = require('body-parser');//node.js 中间件，用于处理 JSON, Raw, Text 和 URL 编码的数据。

// 路由信息（接口地址），存放在routes的根目录
var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

// 载入中间件
app.use(logger('dev'));
app.use(express.json());
app.use(bodyParser.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

//配置路由，（'自定义路径'，上面设置的接口地址）
app.use('/', indexRouter);
app.use('/users', usersRouter);


module.exports = app;
