<!DOCTYPE html>
<html>
    <head>
        <title>viewMoviesByGenre-Result.ftl</title>
        <link href="styleSheet.css" rel="stylesheet" />
    </head>

    <body>

        <h1>View Movies by Genre</h1>
        <p>Use the dropdown box to select the genre of movies you wish to view.</p>

        <form action="GenerateMoviesByGenre">
            <div>

                <div class="styled-select">
                <select name="genre">
                    <#list genres as genre>
                        <option>${genre}</option>
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