package refactula.minecraft;

import java.awt.Color;

public enum Blocks implements Block {

    BEDROCK {
        @Override
        public boolean isSolid() {
            return true;
        }

        @Override
        public Color getColor() {
            return Color.BLACK;
        }
    },

    DIRT {
        @Override
        public boolean isSolid() {
            return true;
        }

        @Override
        public Color getColor() {
            return new Color(0x5f4500);
        }
    },

    GRASS {
        @Override
        public boolean isSolid() {
            return true;
        }

        @Override
        public Color getColor() {
            return new Color(0x00ff00);
        }
    },

    AIR {
        @Override
        public boolean isSolid() {
            return false;
        }

        @Override
        public Color getColor() {
            return new Color(0, 0, 0, 0);
        }
    },

}
