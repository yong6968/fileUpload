<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>文件上传</title>
    <!--支持IE9+ chrome fireFox-->
</head>
<body>
<form action="fileUpload.do" method="post"  enctype="multipart/form-data">
    <input type='file'  name='media'>
    <input type="submit" value="上传图片" />
</form>
</body>
</html>
