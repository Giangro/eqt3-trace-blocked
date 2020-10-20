#!/usr/bin/bash
./deploy.sh
echo "starting tool:"
cd target && java -Xms128m -Xmx384m -Xnoclassgc -jar traceblocked-tool-0.1.0.jar && cd ..
