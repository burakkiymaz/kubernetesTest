contentTest=`curl -s localhost:4000 | head -n1 | cut -d ">" -f 2 | cut -d "<" -f 1`
responseTest=`curl -s -o /dev/null -w "%{http_code}" localhost:4000`

if [[ $responseTest = 200 && $contentTest = "TEST" ]];
then
    echo success
    exit 0
else 
    echo failed
    exit 1
fi