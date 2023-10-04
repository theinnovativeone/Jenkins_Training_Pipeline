pipeline{
	agent any
	tools{
		maven 'Maven3'
	}
	triggers{
		cron('H/30 * * * *')
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
            		body: "Test",
			attachLog: true
	        }
    	}
}
