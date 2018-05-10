var express = require('express');
var request=require('request');
var Service=require('node-zookeeper-dubbo');

var opt={
  application:{name:'demon-provider'},
    register:'111.231.193.179:2181',
    dubboVer:'2.6.1',
    root:'dubbo',
    dependencies:{
    Foo:{
      interface:'com.galaxy.demon.service.DemonService',
        version:'LATEST',
        timeout:6000,
        group:'programmer',
        methodSignature:{
            findById:function(id){[{'$class':'java.lang.Long','$':id}]}
        }
    }
    }
}
//opt.java = require('js-to-java');
var  service=new Service(opt);
var getUserObj={
    $class:'com.galaxy.demon.service.DemonService',
    $:{
        a:1,
        b:'getOrg',
        c:{$class:'java.lang.Long',$:1}
    }
};

var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/getUser',function (req,res) {
    Service.Foo.getOrg({'$class':'java.lang.Long','$':'1000'},getUserObj)
        .then(function (data) { res.send(data);})
.catch(function (err) { res.send(err)});
})

module.exports = router;
