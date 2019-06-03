//服务层
app.service('specificationOptionService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../specificationOption/findAll.do');		
	}
	//分页 
	this.findPage=function(pageNo,pageSize,searchEntity){
		return $http.post('../specificationOption/findPage.do?pageNo='+pageNo+'&pageSize='+pageSize, searchEntity);
		//return $http.post('../testdata.json'); //前端测试效果的json文件
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../specificationOption/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../specificationOption/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../specificationOption/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../specificationOption/delete.do?ids='+ids);
	}  	
});
