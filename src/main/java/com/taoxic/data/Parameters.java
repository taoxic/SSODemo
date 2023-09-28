package com.taoxic.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author heguojiao
 * @date 2023/9/28 16:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameters {
    private float  top_p = 0.1f;
    private float temperature = 0;
}
