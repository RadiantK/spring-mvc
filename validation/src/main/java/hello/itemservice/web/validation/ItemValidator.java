package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // isAssignableFrom : 특정 class가 어떤 클래스/인터페이스를 상속/구현했는지 체크
        return Item.class.isAssignableFrom(clazz);
        // Item == clazz
        // Item == subItem(자식)
    }

    // Errors : BindingResult의 부모
    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;

        // ValidationUtils.rejectIfEmpty(bindingResult, "itmeName", "required");
        // 검증 로직
        if (!StringUtils.hasText(item.getItemName())) {
            // errorCode: messagesCodesResolver를 이해해야 한다.
            // required로 시작하는 세밀한 메시지 코드가 있으면 그 메시지를 높은 우선순위로 사용
            errors.rejectValue("itemName", "required");
        }
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            errors.rejectValue("price", "range", new Object[]{1000, 1000000}, null);
        }
        if (item.getQuantity() == null || item.getQuantity() >= 9999) {
            errors.rejectValue("quantity", "max", new Object[]{9999}, null);
        }

        // 특정 필드가 아닌 복합 룰 검증
        if (item.getPrice() != null && item.getQuantity() != null) {
            int resultPrice = item.getPrice() * item.getQuantity();
            if(resultPrice < 10000) {
                errors.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }
    }
}
