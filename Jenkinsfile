pipeline {
    agent any
    tools { 
        maven 'MAVEN_3_8_3' 
        jdk 'JDK_17' 
    }
	
    stages {
        stage ('Compile Stage Lifetravell') {
            steps{
                script{
                    bitbucketStatusNotify(buildState: 'INPROGRESS', buildKey: 'comp', buildName: 'Compile')
                    try {
                       withMaven(maven : 'MAVEN_3_8_3') {
                           sh 'mvn clean compile'
                        }
                    } catch (Exception e) {
                        bitbucketStatusNotify(buildState: 'FAILED', buildKey: 'comp', buildName: 'Compile')
                    }
                    bitbucketStatusNotify(buildState: 'SUCCESSFUL', buildKey: 'comp', buildName: 'Compile') 
                }
            }
        }

        stage ('Testing Stage Lifetravel') {
            steps{
                script{
                    bitbucketStatusNotify(buildState: 'INPROGRESS', buildKey: 'test', buildName: 'Testing')
                    try {
                        withMaven(maven : 'MAVEN_3_8_3') {
                            sh 'mvn test'
                        }
                    } catch (Exception e) {
                        bitbucketStatusNotify(buildState: 'FAILED', buildKey: 'test', buildName: 'Testing')
                    }
                    bitbucketStatusNotify(buildState: 'SUCCESSFUL', buildKey: 'test', buildName: 'Testing')
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
                script{
                    bitbucketStatusNotify(buildState: 'INPROGRESS', buildKey: 'pkg', buildName: 'Package')
                    try {
                        withMaven(maven : 'MAVEN_3_8_3') {
                            sh 'mvn package'
                        }
                    } catch (Exception e) {
                        bitbucketStatusNotify(buildState: 'FAILED', buildKey: 'pkg', buildName: 'Package')
                    }
                    bitbucketStatusNotify(buildState: 'SUCCESSFUL', buildKey: 'pkg', buildName: 'Package')
                }
            }
        }
		// Descomentar cuando se tenga instalado en Tomcat
		stage('Deploy tomcat') {
            steps {
                //echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL} direcion ${env.WORKSPACE}"	
                script {
                    sh "curl -T /target/lifetravel.war 'http://tomcat:tomcat@http://172.174.244.114:8080/manager/text/deploy?path=/sample&update=true'"
                }
            }
        }

    }
}
