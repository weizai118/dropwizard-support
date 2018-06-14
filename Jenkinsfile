String jdkVersion = 'Java 8'

String mavenVersion = 'Maven 3.3.x'
String mavenSettings = 'public-settings.xml'
String mavenRepo = '.repo'
String mavenOptions = '-V -B -e'

String deployBranch = 'master'

pipeline {
  options {
    buildDiscarder(
      logRotator(numToKeepStr: '100', daysToKeepStr: '14',  artifactNumToKeepStr: '20', artifactDaysToKeepStr: '10')
    )
    disableConcurrentBuilds()
    timestamps()
  }

  agent {
    label 'ubuntu-zion'
  }

  triggers {
    pollSCM('*/15 * * * *')
  }

  tools {
    maven mavenVersion
    jdk jdkVersion
  }

  stages {
    stage('Build') {
      when {
        not {
          branch deployBranch
        }
      }
      steps {
        withMaven(maven: mavenVersion, jdk: jdkVersion, mavenSettingsConfig: mavenSettings, mavenLocalRepo: mavenRepo,
            // disable automatic artifact publisher
            options: [ artifactsPublisher(disabled: true) ]) {
          sh "mvn $mavenOptions clean install"
        }
      }
    }

    stage('Deploy') {
      when {
        branch deployBranch
      }
      steps {
        withMaven(maven: mavenVersion, jdk: jdkVersion, mavenSettingsConfig: mavenSettings, mavenLocalRepo: mavenRepo,
            // disable automatic artifact publisher
            options: [ artifactsPublisher(disabled: true) ]) {
          sh "mvn $mavenOptions clean deploy"
        }
      }
    }
  }

  post {
    always {
      // purge workspace after build finishes
      deleteDir()
    }
  }
}
