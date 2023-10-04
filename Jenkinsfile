pipeline{
	agent any
	tools{
		maven 'Maven3'
	}
	stages{
		stage("Code Checkout"){
			steps{
				bat "echo hello"
			}
		}
		stage("Code Build"){
			steps{
				bat "mvn clean"
			}
		}
		stage("Test"){
			steps{
				bat "mvn test"
			}
		}
	}
	post {
	        always {
			mail to: "guptasneha2099@gmail.com",
            		subject: "Test Email",
            		body: "This is a test email which is triggered after the execution of a pipeline job in Jenkins."
	        }
    	}
}
