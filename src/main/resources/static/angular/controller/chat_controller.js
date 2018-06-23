'use strict';

App.controller('chatcontroller', ['$scope', 'chatservice', function($scope, chatservice) {
          var self = this;
          self.clients={
        		  'id': null,
        		  'sessionId': '',
        		  'clientName': '',
        		  'clientId':  '',
        		  'clientEmailId': '',
        		  'clientAddress': ' ',
        		  'clientHost': '',
        		  'clientPort': '',
        		  'clientType': '',
        		  'clietLocation': ' ',
        		  'status': ''
        		  };
          
          self.clients=[];
          
          self.greating="hello world";
      
          self.fetchAllClients = function(){
        	  chatservice.fetchAllClients()
                  .then(
      					       function(d) {
      						        self.clients = d;
      						    },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
      
          self.fetchAllClients();
          console.log("Clients "+self.clients);
          
          /*self.createEmployee = function(emp){
        	  empService.createUser(emp)
		              .then(
                      self.fetchAllEmployee, 
				              function(errResponse){
					               console.error('Error while creating User.');
				              }	
                  );
          };*/

         /*self.updateEmployee = function(emp, empId){
        	 empService.updateUser(emp, empId)
		              .then(
				              self.fetchAllEmployee, 
				              function(errResponse){
					               console.error('Error while updating User.');
				              }	
                  );
          };*/

/*         self.deleteEmployee = function(empId){
        	 empService.deleteEmployee(empId)
		              .then(
				              self.fetchAllEmployee, 
				              function(errResponse){
					               console.error('Error while deleting User.');
				              }	
                  );
          };*/

          
         /* self.submit = function() {
              if(self.emp.empId==null){
                  console.log('Saving New User', self.emp);    
                  self.createEmployee(self.emp);
              }else{
                  self.updateEmployee(self.emp, self.emp.empId);
                  console.log('User updated with id ', self.emp.empId);
              }
              self.reset();
          };*/
              
          /*self.edit = function(empId){
              console.log('id to be edited', empId);
              for(var i = 0; i < self.emps.length; i++){
                  if(self.emps[i].empId == empId) {
                     self.emp = angular.copy(self.emps[i]);
                     break;
                  }
              }
          };*/
/*              
          self.remove = function(empId){
              console.log('id to be deleted', empId);
              if(self.emp.empId === empId) {//clean form if the user to be deleted is shown there.
                 self.reset();
              }
              self.deleteEmployee(empId);
          };
*/
          
         /* self.reset = function(){
        	  self.emp={empId:null,empName:'',empAdd:'',empEmail:''};
              
              $scope.myForm.$setPristine(); //reset Form
          };*/

      }]);
