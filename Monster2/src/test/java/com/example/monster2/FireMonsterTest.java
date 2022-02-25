package com.example.monster2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireMonsterTest {
    @Test
    void attack_should_return_valid_data() {
        FireMonster fireMonster = new FireMonster("whatever");
        String attackMessage = fireMonster.attack();
        Assertions.assertThat(attackMessage).isEqualTo("whateverattack with fire");
    }
}