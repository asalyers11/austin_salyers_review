<!DOCTYPE html>
<html> 
   <head>
        <title>MovieInfoAndReviews-Result.ftl</title>
        <link href="styleSheet.css" rel="stylesheet" />
    </head>

    <body>

        <h1>Movie Information</h1>
        
        <table border="1">
                <tr><th>Title</th><th>Year</th><th>Rank</th></tr>
                <tr><td>${movie.name}</td><td>${movie.year}</td><td>${movie.rank}</td></tr>           
        </table>

        <h2>Reviews</h2>

        <#list reviews as r>
        <blockquote>
            <p>${r.review}</p>
        </blockquote>
        </#list>

        <hr />

        <div>
            <a href="index.html" >Home</a>
            <a href="MovieSelect" >Back</a>
        </div>
                
    </body>
</html>

