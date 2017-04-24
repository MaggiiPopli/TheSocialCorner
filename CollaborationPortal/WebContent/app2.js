/*var app=angular.module('myApp',['ngRoute','ngCookies']);

app.config(function($routeProvider){
	console.log("APP.js ");
	
$routeProvider


 * 
 * Admin Mapping
.when('/', {
	templateUrl : 'l_user/home.html'
})
.when('/login',{
templateUrl : 'l_user/login.html',
controller : 'UserController'
})
.when('/register',{
templateUrl : 'l_user/registration.html',
controller : 'UserController'
})
.when('/myprofile',{
templateUrl : 'l_user/myprofile.html',
controller : 'UserController'
})

});

app.run( function ($rootScope, $location,$cookieStore, $http) {

	//$on is monitoring
	 $rootScope.$on('$locationChangeStart', function (event, next, current) {
		 console.log("$locationChangeStart")
		 //http://localhost:8080/Collaboration/addjob
	        // redirect to login page if not logged in and trying to access a restricted page
		 //$.inArray(x,A)==1 =>it will return 1(true) or -1(false).If the x is there in array A it will return true otherwise false.
		 //Without Login they can access these pages.
		 //If the location.path is not equal to /search_job or '/view_blog' then this is restricted page.
	        var restrictedPage = $.inArray($location.path(), ['','/','/login','/register','/view_jobdetails','/post_job','/view_applied_job','/view_blog','/login', '/registration','/list_blog','/create_blog','/create_forum','/view_forum','/list_forum','/search_friend','/pending_request','/chat','/friend_details','/friend_list']) === -1;
		 console.log("Navigating to page :" + $location.path())
	        console.log("restrictedPage:" +restrictedPage)
	        console.log("currentUser:" +$rootScope.currentUser.username)
	        var loggedIn = $rootScope.currentUser.username;
		 $rootScope.loggedIn=loggedIn;
		 var loggedInRole=$rootScope.currentUser.role;
		 if(loggedInRole=='admin')
			 {$rootScope.loggedInRole=loggedInRole;}
		 
		 console.log('value of loggedin',$rootScope.loggedIn)
	        
	        console.log("loggedIn:" +loggedIn)
	        
	        if(!loggedIn)
	        	{
	        	
	        	 if (restrictedPage) {
		        	  console.log("Navigating to login page:")
		        	

						            $location.path('/');
		                }
	        	}
	        
			 else //logged in
	        	{
	        	
				 var role = $rootScope.currentUser.role;
				 
	        	
	        	}
	        
	 }
	       );
	 
	 
	 // keep user logged in after page refresh
    $rootScope.currentUser = $cookieStore.get('currentUser') || {};
    if ($rootScope.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser; 
    }

});

*/

//var app = angular.module('myApp', [ 'ngRoute','ngCookies','ngFileUpload' ]);
var app = angular.module('myApp', [ 'ngRoute','ngCookies']);
app.config(function($routeProvider) {
	$routeProvider

	.when('/', {
		templateUrl : 'l_user/home.html'
	})
	.when('/login',{
	templateUrl : 'l_user/login.html',
	controller : 'UserController'
	})
	.when('/register',{
	templateUrl : 'l_user/registration.html',
	controller : 'UserController'
	})
	.when('/myprofile',{
	templateUrl : 'l_user/myprofile.html',
	controller : 'UserController'
	})
	.when('/createblog',{
	templateUrl : 'l_blog/createblog.html',
	controller : 'BlogController'
	})

	

});

app.run( function ($rootScope, $location,$cookieStore, $http) {

	 $rootScope.$on('$locationChangeStart', function (event, next, current) {
		 console.log("$locationChangeStart")
		 //http://localhost:8080/Collaboration/addjob
	        // redirect to login page if not logged in and trying to access a restricted page
	        var restrictedPage = $.inArray($location.path(), ['','/','/search_job','/view_blog','/login', '/register','/list_blog','/createblog']) === -1;
		 console.log("Navigating to page :" + $location.path())
	        console.log("restrictedPage:" +restrictedPage)
	        console.log("currentUser:" +$rootScope.currentUser)
	        var loggedIn = $rootScope.currentUser;
	        
	        console.log("loggedIn:" +loggedIn)
	        
	        if(!loggedIn)
	        	{
	        	
	        	 if (restrictedPage) {
		        	  console.log("Navigating to login page:")
		        	

						            $location.path('/login');
		                }
	        	}
	        
			 else //logged in
	        	{
	        	
				 var role = $rootScope.currentUser.role;
				 var userRestrictedPage = $.inArray($location.path(), ["/post_job"]) == 0;
				 
				 if(userRestrictedPage && role!='admin' )
					 {
					 
					  alert("You can not do this operation as you are logged as : " + role )
					   $location.path('/login');
					 
					 }
				     
	        	
	        	}
	        
	 }
	       );
	 
	 
	 // keep user logged in after page refresh
     $rootScope.currentUser = $cookieStore.get('currentUser') || {};
     if ($rootScope.currentUser) {
         $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser; 
     }

});


 
    
    
