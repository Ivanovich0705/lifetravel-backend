pipeline {
    agent any
    tools { 
        maven 'MAVEN_3_8_3' 
        jdk 'JDK_17' 
    }
	
    stages {
        stage ('Compile Stage Lifetravel') {
            steps{
                
                       withMaven(maven : 'MAVEN_3_8_3') {
                           sh 'mvn clean compile'
                        }
                    
            }
        }

        stage ('Testing Stage Lifetravel') {
            steps{
                
                        withMaven(maven : 'MAVEN_3_8_3') {
                            sh 'mvn test'
                        }
                    
            }
        }

	 /*stage ('sonarQube Analysis') {
		steps {
			withSonarQubeEnv('sonarLocal') {
				sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=one'
			}
		}
	}*/

        stage ('package Stage Lifetravel') {
            steps{
                
                        withMaven(maven : 'MAVEN_3_8_3') {
                            sh 'mvn package'
                        }
                    
            }
        }
	    
	    stage('Notify Discord') {
            steps {
                discordSend(
                    color: 'GOOD',
                    message: 'Build successful!',
                    webhookUrl: 'https://discord.com/api/webhooks/1102325036188188682/KCwm8aPhzoDTTvBSCoS8BtdLADNihkIWyGltcl05NU6PuZA9U257iqlwjF4Ku9dVw8TE'
                )
            }
        }
		// Descomentar cuando se tenga instalado en Tomcat
		stage('Deploy tomcat') {
           steps {
        timeout(time: 5, unit: 'MINUTES') {
            input "Deploy to tomcat?"
        }
        withMaven(maven: 'MAVEN_3_8_3') {
            sh "curl -T target/lifetravel-backend-1.war 'http://deployer:deployer@172.174.244.114:8080/manager/text/deploy?path=/github-backend&update=true'"
        }
    }
        }

    }
}
