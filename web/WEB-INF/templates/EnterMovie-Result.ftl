<!DOCTYPE html>
<html> 
   <head>
        <title>EnterMovie-Result.ftl</title>
        <link href="styleSheet.css" rel="stylesheet" />
    </head>

    <body>
        
        
        <h1>Enter a New Movie</h1>
        
        <#if status?has_content >
            <p>${status}</p>
        </#if>
        <form action="StoreMovie">
            <div>
                <fieldset>
                    <label>Title: <input type="text" name="title" /></label> <br />
                    <label>Year:  <input type="text" name="year"  /></label> <br />
                    <label>rank:  <input type="number" name="rank" step="0.1" /></label> <br />
                    <input type="submit" value="Submit Movie" />
                </fieldset>
            </div>
        </form>

        <hr />

        <div>
            <a href="index.html" >Home</a>
        </div>
                
    </body>
</html>
