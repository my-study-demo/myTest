package com.kely;

import java.io.Serializable;
import java.util.List;

class Item implements Serializable {
        private Spec spec;
        private List<Option> list;

    public Item() {
    }

    public Item(Spec spec, List<Option> list) {
            this.spec = spec;
            this.list = list;
        }

        public Spec getSpec() {
            return spec;
        }

        public void setSpec(Spec spec) {
            this.spec = spec;
        }

        public List<Option> getList() {
            return list;
        }

        public void setList(List<Option> list) {
            this.list = list;
        }
    }