package raven.effect;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class RippleEffect {

    private final Component component;
    private Color rippleColor = new Color(255, 255, 255);
    private List<Effect> effects;

    /**
     *
     * @param component
     */
    public RippleEffect(Component component) {
        this.component = component;
        init();
    }

    private void init() {
        effects = new ArrayList<>();
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    addEffect(e.getPoint());
                }
            }
        });
    }

    /**
     *
     * @param location
     */
    public void addEffect(Point location) {
        effects.add(new Effect(component, location));
    }

    /**
     *
     * @param g
     * @param contain
     */
    public void reder(Graphics g, Shape contain) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < effects.size(); i++) {
            Effect effect = effects.get(i);
            if (effect != null) {
                effect.render(g2, contain);
            }
        }
        g2.dispose();
    }

    private class Effect {

        private final Component component;
        private final Point location;
        private Animator animator;
        private float animate;

        public Effect(Component component, Point location) {
            this.component = component;
            this.location = location;
            init();
        }

        private void init() {
            animator = new Animator(500, new TimingTargetAdapter() {
                @Override
                public void timingEvent(float fraction) {
                    animate = fraction;
                    component.repaint();
                }

                @Override
                public void end() {
                    effects.remove(Effect.this);
                }
            });
            animator.setResolution(5);
            animator.setDeceleration(.5f);
            animator.setAcceleration(.5f);
            animator.start();
        }

        /**
         *
         * @param g2
         * @param contain
         */
        public void render(Graphics2D g2, Shape contain) {
            Area area = new Area(contain);
            area.intersect(new Area(getShape(getSize(contain.getBounds2D()))));
            g2.setColor(rippleColor);
            float alpha = 0.3f;
            if (animate >= 0.7f) {
                double t = animate - 0.7f;
                alpha = (float) (alpha - (alpha * (t / 0.3f)));
            }
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2.fill(area);
        }

        /**
         *
         * @param size
         * @return
         */
        private Shape getShape(double size) {
            double s = size * animate;
            double x = location.getX();
            double y = location.getY();
            Shape shape = new Ellipse2D.Double(x - s, y - s, s * 2, s * 2);
            return shape;
        }

        /**
         *
         * @param rec
         * @return
         */
        private double getSize(Rectangle2D rec) {
            double size;
            if (rec.getWidth() > rec.getHeight()) {
                if (location.getX() < rec.getWidth() / 2) {
                    size = rec.getWidth() - location.getX();
                } else {
                    size = location.getX();
                }
            } else {
                if (location.getY() < rec.getHeight() / 2) {
                    size = rec.getHeight() - location.getY();
                } else {
                    size = location.getY();
                }
            }
            return size + (size * 0.1f);
        }
    }

    /**
     *
     * @param rippleColor
     */
    public void setRippleColor(Color rippleColor) {
        this.rippleColor = rippleColor;
    }

    /**
     *
     * @return
     */
    public Color getRippleColor() {
        return rippleColor;
    }
}
