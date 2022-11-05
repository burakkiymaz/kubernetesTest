contentTest=`curl -s localhost:4000 | head -n1 | cut -d ">" -f 2 | cut -d "<" -f 1`
responseTest=`curl -s -o /dev/null -w "%{http_code}" localhost:4000`

if [[ $responseTest = 200 ]];
then
    echo Response test successful
else 
    echo Test failed because response expected 200 but returned $responseTest 
    exit 1
fi

if [[ $contentTest = "TEST" ]];
then
    echo Content test successful
else 
    echo Test failed because response expected TEST but returned $contentTest
    exit 1
fi

exit 0