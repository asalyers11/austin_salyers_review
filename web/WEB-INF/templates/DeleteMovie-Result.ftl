<!DOCTYPE html>
<html>
    <head>
        <title>DeleteMovie-Result.ftl</title>
        <link href="styleSheet.css" rel="stylesheet" />
    </head>

    <body>

        <h1>Delete a Movie</h1>
        
        
        <#if status?has_content >
            <p>${status}</p>
        </#if>
        
        <p>Use the dropdown box to select the movie</p>

        <form action="DeleteSelectedMovie">
            <div>
                
                <div class="styled-select">
                <select name="movieTitle">
                    <#list movieTitles as movieTitle>
                        <option>${movieTitle}</option>
                    </#list>
                </select>
                </div>


                <input type="submit" value="delete" />

            </div>
        </form>

        <hr />

        <div>
            <a href="index.html" >Home</a>
        </div>

    </body>
</html>


