<!DOCTYPE html>
<html> 
   <head>
        <title>GenerateMovies-Result.ftl</title>
        <link href="styleSheet.css" rel="stylesheet" />
    </head>

    <body>

        <h1>Movie titles from ${genre} movies</h1>
        
        <table>
            <caption>Movie Titles</caption>
            <#list movieTitles as movieTitle>
                <tr><td>${movieTitle}</td></tr>
            </#list>
        </table>

        <hr />

        <div>
            <a href="index.html" >Home</a>
            <a href="ViewMoviesByGenreServlet" >Back</a>
        </div>
                
    </body>
</html>
