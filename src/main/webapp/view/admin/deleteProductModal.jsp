<%-- 
    Document   : deleteProductModal
    Created on : 24 thg 6, 2025, 23:40:57
    Author     : legion
--%>

<div class="modal fade" id="delete-product-modal" tabindex="-1" role="dialog" aria-labelledby="delete-modal-label" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="delete-modal-label">Xác nh?n xoá</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>B?n có ch?c ch?n mu?n xóa?</p>
            </div>
            <div class="modal-footer">
                <form action="product?action=delete" method="POST">
                    <div class="form-group" style="display: none">
                        <input type="text" class="form-control" id="idDeleteInputBook" name="idBook" value="">
                        <input type="text" class="form-control" id="idDeleteInputBookVar" name="idBookVar" value="">
                    </div>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
                    <button type="submit" class="btn btn-danger">Có</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function deleteProductModal(id1 , id2) {
        let inputIdBook = document.querySelector("#idDeleteInputBook");
        inputIdBook.value = id1;
        let inputIdBookVar = document.querySelector("#idDeleteInputBookVar");
        inputIdBookVar.value = id2 ;
    }
</script>