<!DOCTYPE html>
<html>
    <head>
        <title>MovieSelect-Result.ftl</title>
        <link href="styleSheet.css" rel="stylesheet" />
    </head>

    <body>

        <h1>Write a Review</h1>
        
        
        <#if status?has_content >
            <p>${status}</p>
        </#if>
        
        <p>Use the dropdown box to select the movie</p>

        <form action="StoreReview">
            <div>
                
                <div class="styled-select">
                <select name="movieTitle">
                    <#list movieTitles as movieTitle>
                        <option>${movieTitle}</option>
                    </#list>
                </select>
                </div>

                <p>Write your review in the following text box</p>
                <textarea name="review"></textarea>

                <input type="submit" />

            </div>
        </form>

        <hr />

        <div>
            <a href="index.html" >Home</a>
        </div>

    </body>
</html>

