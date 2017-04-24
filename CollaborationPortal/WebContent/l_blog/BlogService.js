/*'use strict';

app.factory('BlogService', ['$http', '$q', '$rootScope', function($http, $q, $rootScope){
	
	console.log("Starting BlogService")
	
	var BASE_URL = 'http://localhost:8080/CollaborationPortalBackend';
	
	return  {
		
		fetchAllBlogs: function(){
			
			console.log("Calling fetchALLBLOGS")
			return
					{
				$http.get(BASE_URL+'/getBlogs')
				.then(
						
						function(response){
							return response.data;
							
						},
						null
					);
				}
			},
			
			createBlog : function(blog){
				console.log("calling createBlog..")
				return $http.post('http://localhost:8080/CollaborationPortalBackend/createblog/'+blog)
				.then(
						function(response){
							return response.data();
							
						},
						function(errResponse){
							console.error("Error while creating blog");
							return $q.reject(errResponse)
						}
				);
				
			}
				
			}
			
		
}]);
*/
'use strict'
app.factory('BlogService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
 
    var REST_SERVICE_URI = 'http://localhost:8080/CollaborationPortalBackend';
 return{
	 
	 fetchAllBlogs:function(){
	 console.log('fetchAllBlogs Method in BlogServices')
	 return $http.get(REST_SERVICE_URI+'/blogs/')
	 .then(
	function(response){
		console.log('success in BlogService',response.data)
		return response.data;
	},
	function(errResponse){
		console.error('Error while fetching the Blogs');
		return $q.reject(errResponse);
	}
	 );
	 
 },
 createBlog:function(blog)
 {
	 console.log('Blog service')
	 return $http.post(REST_SERVICE_URI+'/createblog/',blog).success(function(data) {
      console.log("sucess 11")
    }).error(function(data) {
     console.log("failure ")
    });
	 //return $http.post(REST_SERVICE_URI+'/createblog/',blog);
 }
	 /*.then(function(response){
		 console.log('blog created successfully');
		 return response.data;
		 
	 },
	 function(errResponse){
		 console.error('Error while creating the blog');
		 return $q.reject(errResponse);
		 
	 }
			 
	 );*/
 
 
 /*this.isCodeValid = function (code) {
     return $http.get("/api/clockin/iscodevalid?code=" + code);
   };
   
   $http.get('/api/ponies').success(function(data) {
      successCallbackFn(data);
    }).error(function(data) {
      errorCallbackFn(data);
    }); */
 
 }
 }]);