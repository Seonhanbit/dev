package com.ssafy.edu.vue.help;
/* Ajax 결과 리턴용 Helper class*/
public class AjaxResult {

    private String result;/*결과담을 필드*/

    public AjaxResult() {
    }

    public AjaxResult(String result) {
        this.result = result;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
//     @PutMapping(value = "/{id}", consumes = "application/json") /* 할일 완료 여부 */
//    ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Todo todo) {
//        todo.setId(id);
//        AjaxResult ajaxResult = new AjaxResult();
//        if (service.complete(todo)) {
//            ajaxResult.setResult("SUCS");
//
//        } else {
//            ajaxResult.setResult("FAIL");
//
//        }
//        return new ResponseEntity<AjaxResult>(ajaxResult, HttpStatus.OK);
//    }
