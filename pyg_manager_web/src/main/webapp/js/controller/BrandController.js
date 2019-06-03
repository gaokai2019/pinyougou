app.controller('brandController',function ($scope,brandService,$controller) {

    //前端假继承,通过$controller指令将$scope范围打通
    $controller('baseController',{$scope:$scope});

    //ajax请求后端findAll方法
    /*  $scope.findAll = function () {
          $http.get('../brand/findAll.do').success(
              function (response) {
                  $scope.list = response;
              }
          )
      }*/

    $scope.searchEntity = {}; //打开页面查询时，的查询时防止没有赋值

    //定义分页方法
    $scope.findPage = function(){
        brandService.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows; //显示的list内容
                $scope.paginationConf.totalItems = response.total;  //将总记录数设置到分页插件参数上
            }
        )
    }



    $scope.entity = {}; //定义变量

    //新增方法
    $scope.save = function () {
        if($scope.entity.id == null){ //新增
            brandService.insert($scope.entity).success(
                function (response) {
                    //新增成功刷新页面
                    if(response.success){ //Result success,message
                        $scope.findPage(); //刷新
                    }else{
                        alert(response.message);
                    }
                }
            )
        }else{ //修改
            brandService.update($scope.entity).success(
                function (response) {
                    //新增成功刷新页面
                    if(response.success){ //Result success,message
                        $scope.findPage(); //刷新
                    }else{
                        alert(response.message);
                    }
                }
            )
        }
    }

    //数据回显
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;//{id:xxx,name:'xxx',firstChar:'xxxx'}
            }
        )
    }

    //品牌删除方法
    $scope.del = function () {
        brandService.del($scope.selectIds).success(
            function (response) {
                //删除成功刷新页面
                if(response.success){ //Result success,message
                    $scope.findPage(); //刷新

                    $scope.selectIds = [];
                }else{
                    alert(response.message);
                }
            }
        )
    }



})


