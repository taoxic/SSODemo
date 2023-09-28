package com.taoxic.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author heguojiao
 * @date 2023/9/27 17:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QwenTranslateContentRequest {
    private String model = "qwen-turbo";
    private TranslateInput input;
    private Parameters parameters;
}
