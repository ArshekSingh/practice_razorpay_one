package com.example.practice_razorpay_one.enums;

/**
 * Status: "P" : Pending, "C": Collected, "F": Failed
 **/
public enum Collection {

    COLLECTED {
        @Override
        public String toString() {
            return "C";
        }
    },
    PENDING {
        @Override
        public String toString() {
            return "P";
        }
    },
    FAILED {
        @Override
        public String toString() {
            return "F";
        }
    }

}
