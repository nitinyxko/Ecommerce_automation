#!/bin/bash
echo "Starting Katalon Test Execution"
cd /Applications/Katalon\ Studio.app/Contents/MacOS
./katalon -noSplash -runMode=console -projectPath="/path/to/ResumeReadyAutomationFramework" -retry=0 -testSuitePath="Test Suites/Smoke_Test_Suite" -executionProfile="default" -browserType="Chrome (headless)"
echo "Test execution completed"