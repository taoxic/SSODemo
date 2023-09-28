package com.taoxic.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author heguojiao
 * @date 2023/9/28 16:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslateOutput {
    private TranslateResult output;
    private Usage usage;
    private String request_id;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class TranslateResult {
        private String finish_reason;
        private String text;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Usage {
        private int  total_tokens;
        private int  output_tokens;
        private int  input_tokens;
    }
}
