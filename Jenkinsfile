pipeline {
    agent any
    tools { 
        maven 'MAVEN_3_8_3' 
        jdk 'JDK_17' 
    }
	
    stages {
        stage ('Compile Stage Lifetravel') {

            steps {
                withMaven(maven : 'MAVEN_3_8_3') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage Lifetravel') {

            steps {
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
            steps {
                withMaven(maven : 'MAVEN_3_8_3') {
                    sh 'mvn package'
                }
            }
        }
		/* // Descomentar cuando se tenga instalado en Tomcat
		stage('Deploy tomcat') {
            steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL} direcion ${env.WORKSPACE}"	
                withMaven(maven : 'MAVEN_3_6_3') {
					bat '"C:\\Program Files\\Git\\mingw64\\bin\\curl.exe" -T ".\\target\\sistema-ventas-spring.war" "http://tomcat:tomcat@localhost:9090/manager/text/deploy?path=/sistema-ventas-spring&update=true"'
                } 
            }
        }*/

    }
}
