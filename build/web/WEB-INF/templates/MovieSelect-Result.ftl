<!DOCTYPE html>
<html>
    <head>
        <title>MovieSelect-Result.ftl</title>
        <link href="styleSheet.css" rel="stylesheet" />
    </head>

    <body>

        <h1>View Movie Info and Reviews</h1>
        <p>Use the dropdown box to select the movie</p>

        <form action="MovieInfoAndReviews">
            <div>

                <div class="styled-select">
                <select name="movieTitle">
                    <#list movieTitles as movieTitle>
                        <option>${movieTitle}</option>
                    </#list>
                </select>
                </div>

                <input type="submit" />
            </div>
        </form>

        <hr />

        <div>
            <a href="index.html" >Home</a>
        </div>

    </body>
</html>
