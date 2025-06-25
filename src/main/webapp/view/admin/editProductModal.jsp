<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="editProductModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editBookModalLabel">Edit Book</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editBookForm" action="product?action=edit" method="POST" enctype="multipart/form-data">
                    <div class="form-group" style="display: none">
                        <input type="text" class="form-control" id="idEditInput" name="id">
                    </div>
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="nameEditInput" name="name">
                        <div id="nameEditError" class="error"></div>
                    </div>
                    <div class="form-group">
                        <label for="author">Author:</label>
                        <input type="text" class="form-control" id="authorEditInput" name="author">
                    </div>
                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="text" class="form-control" id="priceEditInput" name="price">
                        <div id="priceEditError" class="error"></div>
                    </div>
                    <div class="form-group">
                        <label for="quantity">Quantity:</label>
                        <input type="text" class="form-control" id="quantityEditInput" name="quantity">
                        <div id="quantityEditError" class="error"></div>
                    </div>
                    <div class="form-group">
                        <label for="category">Category: </label>
                        <div class="input-group">
                            <select class="custom-select" id="categoryEditInput" name="category">
                                <c:forEach items="${listCategory}" var="category">
                                    <option value="${category.category_id}">${category.category_name}</option>
                                </c:forEach>
                            </select>
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button">Category</button>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="image">Image: </label>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Upload</span>
                            </div>
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="imageEdit" name="image"
                                       onchange="displayImage2(this)">
                                <label class="custom-file-label">Choose file</label>
                            </div>
                        </div>
                        <img id="previewImage2" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="Preview"
                             style="display: none; max-width: 300px; max-height: 300px;">
                        <input type="hidden" id="currentImage" name="currentImage" value="">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-primary" form="editBookForm"
                        onclick="validateForm2(event)">Update</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        window.validateForm2 = function (event) {
            event.preventDefault();

            let name = $('#nameEditInput').val();
            let price = $('#priceEditInput').val();
            let quantity = $('#quantityEditInput').val();

            $('.error').html('');

            if (name === '') {
                $('#nameEditError').html('Tên sách không được để trống');
            }

            if (price === '') {
                $('#priceEditError').html('Giá của quyển sách không được để trống');
            } else if (!$.isNumeric(price) || parseFloat(price) < 0) {
                $('#priceEditError').html('Giá của quyển sách phải là số và không được nhỏ hơn 0');
            }

            if (quantity === '') {
                $('#quantityEditError').html('Số lượng sách không được để trống');
            } else if (!$.isNumeric(quantity) || parseInt(quantity) < 0) {
                $('#quantityEditError').html('Số lượng của quyển sách phải là số và không được nhỏ hơn 0');
            }

            let error = '';
            $('.error').each(function () {
                error += $(this).html();
            });

            if (error === '') {
                $('#editBookForm').submit();
            }
        };

        window.displayImage2 = function (input) {
            var previewImage = document.getElementById("previewImage2");
            var file = input.files[0];
            var reader = new FileReader();

            reader.onload = function (e) {
                previewImage.src = e.target.result;
                previewImage.style.display = "block";
            };

            reader.readAsDataURL(file);
        };

        window.editProductModal = function (button) {
            let id = $(button).closest('tr').find('td[name="id"]').text().trim();
            let title = $(button).closest('tr').find('td[name="title"]').text().trim();
            let author = $(button).closest('tr').find('td[name="author"]').text().trim();
            let price = $(button).closest('tr').find('td[name="price"]').text().trim().split('$')[0];
            let stock = $(button).closest('tr').find('td[name="stock"]').text().trim();
            let category = $(button).closest('tr').find('td[name="category"]').text().trim();
            let image = $(button).closest('tr').find('td[name="image"] img').attr('src');

            $('#idEditInput').val(id);
            $('#nameEditInput').val(title);
            $('#authorEditInput').val(author);
            $('#priceEditInput').val(price);
            $('#quantityEditInput').val(stock);

            $('#categoryEditInput option').each(function () {
                if ($(this).text().trim() === category) {
                    $(this).prop('selected', true);
                }
            });

            $('#previewImage2').attr('src', image).css('display', 'block');
            $('#currentImage').val(image);
        };

        $('#imageEdit').on('change', function () {
            var fileName = $(this).val().split('\\').pop();
            $(this).next('.custom-file-label').addClass("selected").html(fileName);
        });
    });
</script>
