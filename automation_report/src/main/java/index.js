function logResults(json) {
    console.log(json)
}

$.ajax({
    url: "https://raw.githubusercontent.com/cben/sandbox/master/json/index.json",
    dataType: "json"
}).done(function(result){
    console.log(result);
});