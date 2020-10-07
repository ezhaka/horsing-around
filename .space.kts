
/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, refer to https://www.jetbrains.com/help/space/automation.html
*/

job("Kaiser Chiefs — Don't Just Stand There, Do Something It would be useful if you knew That everything you say and do Potentially could change tomorrow") {
    container("hello-world")
}

job("Manual") {
    startOn {
        gitPush { enabled = false }
    }
    
    container("openjdk:11") {
        kotlinScript { api ->
            throw Exception("kek")
        }
    }
}