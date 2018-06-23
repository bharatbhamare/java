'use strict';

App.factory('chatservice', ['$http', '$q', function($http, $q){

	return {
		
		fetchAllClients: function() {
					return $http.get('http://localhost:8080/chat/clients')
							.then(
									function(response){
										console.log(response);
										return response.data;
										
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										alert('error '+errResponse)
										return $q.reject(errResponse);
									}
							);
			},
		    
			createUser: function(emp){
				console.log(emp);
					return $http.post('http://localhost:8080/employee', emp)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateUser: function(emp, empId){
					return $http.put('http://localhost:8080/employee/'+empId, emp)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating user');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteEmployee: function(empId){
					return $http.delete('http://localhost:8080/employee/'+empId)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting user');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
