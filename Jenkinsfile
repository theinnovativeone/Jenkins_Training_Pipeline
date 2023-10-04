pipeline{
	agent any
	tools{
		maven 'Maven3'
	}
	triggers{
		cron('H/40 * * * *')
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
		stage("Deploy"){
			steps{
				echo "Deploying the code!"
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
