<!DOCTYPE html>
<html> 
   <head>
        <title>MovieInfoAndReviews-Result.ftl</title>
        <link href="styleSheet.css" rel="stylesheet" />
    </head>

    <body>

        <h1>Delete a Review</h1>
        
        <table border="1">
                <tr><th>Title</th><th>Year</th><th>Rank</th></tr>
                <tr><td>${movie.name}</td><td>${movie.year}</td><td>${movie.rank}</td></tr>           
        </table>
        
        <h2>Reviews</h2>

        <form action="DeleteSelectedReview">
            <div>
                <#list reviews as r>
                    <label><input type="radio" name="id" value="${r.id}" /> ${r.review}</label> <br />
                </#list>

                <input type="hidden" name="movieTitle" value="${movie.name}" />

                <input type="submit" value="delete" />
            
            </div>
        </form>

        <hr />

        <div>
            <a href="index.html" >Home</a>
            <a href="MovieSelect" >Back</a>
        </div>
                
    </body>
</html>


