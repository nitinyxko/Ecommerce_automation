@echo off
echo Starting Katalon Test Execution
cd /d "C:\KatalonStudio\katalon.exe"
katalon -noSplash -runMode=console -projectPath="C:\YourWorkspace\ResumeReadyAutomationFramework" -retry=0 -testSuitePath="Test Suites/Smoke_Test_Suite" -executionProfile="default" -browserType="Chrome (headless)"
echo Test execution completed
pause