const apiUrl = 'http://localhost:8080/weather/'

export const getWeather = async city => {
    return await fetch(apiUrl + city)
        .then(data => data.json())
}