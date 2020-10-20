call deploy.bat
echo "starting tool:"
cd target && java -Xms128m -Xmx384m -Xnoclassgc -jar tool-0.1.0.jar && cd ..
