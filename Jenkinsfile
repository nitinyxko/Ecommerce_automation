pipeline {
    agent any
    
    stages {
        stage('Build') {
            when { branch 'develop' }
            steps {
                echo 'Building develop branch...'
            }
        }
        
        stage('Test') {
            parallel {
                stage('Smoke Tests') {
                    steps {
                        script {
                            if (isUnix()) {
                                sh 'Scripts/ci/run-tests.sh Smoke_Test_Suite'
                            } else {
                                bat 'Scripts\\ci\\run-tests.bat Smoke_Test_Suite'
                            }
                        }
                    }
                }
                stage('API Tests') {
                    steps {
                        script {
                            if (isUnix()) {
                                sh 'Scripts/ci/run-tests.sh API_Test_Suite'
                            } else {
                                bat 'Scripts\\ci\\run-tests.bat API_Test_Suite'
                            }
                        }
                    }
                }
            }
        }
        
        stage('Deploy to Staging') {
            when { branch 'develop' }
            steps {
                echo 'Deploying to staging...'
            }
        }
        
        stage('Production Tests') {
            when { branch 'main' }
            steps {
                script {
                    if (isUnix()) {
                        sh 'Scripts/ci/run-tests.sh Regression_Test_Suite "Chrome (headless)" production'
                    } else {
                        bat 'Scripts\\ci\\run-tests.bat Regression_Test_Suite "Chrome (headless)" production'
                    }
                }
            }
        }
    }
}
