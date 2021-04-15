var apiclient = (function () {

    var url = "http://localhost:8080/weather"
	//let url="https://buitrago-arsw-t2.herokuapp.com/weather/";
	//let url="localhost:8080/weather/";

     var buscar = function (ciudad,callback){
                    console.log("Put a message here.")
                    $.getJSON(url+"/"+ciudad,(data)=>{
                        callback(data);
                    },null)
                };

    var initMap= function (ciudad){
        fetch(url+ciudad)
            .then(function(response){return response.json()})
            .then(app.plotMarkers);
    }

    return {
        buscar:buscar,
        initMap:initMap
    };

})();