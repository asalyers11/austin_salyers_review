<!DOCTYPE html>
<html>
    <head>
        <title>DeleteMovie-Result.ftl</title>
        <link href="styleSheet.css" rel="stylesheet" />
    </head>

    <body>

        <h1>Delete a Review</h1>
        
        

        
        <p>Use the dropdown box to select the movie from which you wish to delete a review</p>

        <form action="ShowReviews">
            <div>
                <div class="styled-select">
                <select name="movieTitle">
                    <#list movieTitles as movieTitle>
                        <option>${movieTitle}</option>
                    </#list>
                </select>
                </div>


                <input type="submit" value="select" />

            </div>
        </form>

        <hr />

        <div>
            <a href="index.html" >Home</a>
        </div>

    </body>
</html>



