
/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, refer to https://www.jetbrains.com/help/space/automation.html
*/

job("Kaiser Chiefs") {
    container("hello-world")
}

job("e591395b9533179d47775061e591395b9533179d47775061e591395b9533179d47775061e591395b9533179d47775061e591395b9533179d47775061e591395b9533179d47775061") {
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