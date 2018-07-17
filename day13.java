package com.example.android.weather;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

//advent of code day13
//done by Lawrence Jengwa 2018

public final class Day13 {
   private final List layers;

   public final int solvePart1() {
      Iterable $receiver$iv = (Iterable)this.layers;
      Collection destination$iv$iv = (Collection)(new ArrayList());
      Iterator var4 = $receiver$iv.iterator();

      while(var4.hasNext()) {
         Object element$iv$iv = var4.next();
         Day13.Layer it = (Day13.Layer)element$iv$iv;
         if (it.caughtAt(0)) {
            destination$iv$iv.add(element$iv$iv);
         }
      }

      $receiver$iv = (Iterable)((List)destination$iv$iv);
      int sum$iv = 0;

      int var11;
      for(Iterator var12 = $receiver$iv.iterator(); var12.hasNext(); sum$iv += var11) {
         Object element$iv = var12.next();
         Day13.Layer it = (Day13.Layer)element$iv;
         var11 = it.getSeverity();
      }

      return sum$iv;
   }

   public final int solvePart2() {
      return ((Number)SequencesKt.first(SequencesKt.filter(SequencesKt.generateSequence(0, (Function1)null.INSTANCE), (Function1)(new Function1() {
        
         public Object invoke(Object var1) {
            return this.invoke(((Number)var1).intValue());
         }

         public final boolean invoke(int time) {
            Iterable $receiver$iv = (Iterable)Day13.this.layers;
            boolean var10000;
            if ($receiver$iv instanceof Collection && ((Collection)$receiver$iv).isEmpty()) {
               var10000 = true;
            } else {
               Iterator var3 = $receiver$iv.iterator();

               while(true) {
                  if (!var3.hasNext()) {
                     var10000 = true;
                     break;
                  }

                  Object element$iv = var3.next();
                  Day13.Layer it = (Day13.Layer)element$iv;
                  if (it.caughtAt(time)) {
                     var10000 = false;
                     break;
                  }
               }
            }

            return var10000;
         }
      })))).intValue();
   }

   private final List parseInput(List input) {
      Iterable $receiver$iv = (Iterable)input;
      Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
      Iterator var5 = $receiver$iv.iterator();

      Object item$iv$iv;
      while(var5.hasNext()) {
         item$iv$iv = var5.next();
         String it = (String)item$iv$iv;
         List var17 = StringsKt.split$default((CharSequence)it, new String[]{": "}, false, 0, 6, (Object)null);
         destination$iv$iv.add(var17);
      }

      $receiver$iv = (Iterable)((List)destination$iv$iv);
      destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
      var5 = $receiver$iv.iterator();

      while(var5.hasNext()) {
         item$iv$iv = var5.next();
         List it = (List)item$iv$iv;
         Day13.Layer var10000 = new Day13.Layer;
         String var8 = (String)it.get(0);
         Day13.Layer var9 = var10000;
         Day13.Layer var10 = var10000;
         int var11 = Integer.parseInt(var8);
         var8 = (String)it.get(1);
         int var12 = Integer.parseInt(var8);
         var9.<init>(var11, var12);
         destination$iv$iv.add(var10);
      }

      return (List)destination$iv$iv;
   }

   public Day13(@NotNull List input) {
      Intrinsics.checkParameterIsNotNull(input, "input");
      super();
      this.layers = this.parseInput(input);
   }

   
   public static final class Layer {
      private final int severity;
      private final int depth;
      private final int range;

      public final boolean caughtAt(int time) {
         return (time + this.depth) % ((this.range - 1) * 2) == 0;
      }

      public final int getSeverity() {
         return this.severity;
      }

      public Layer(int depth, int range) {
         this.depth = depth;
         this.range = range;
         this.severity = this.depth * this.range;
      }

      private final int component1() {
         return this.depth;
      }

      private final int component2() {
         return this.range;
      }

      @NotNull
      public final Day13.Layer copy(int depth, int range) {
         return new Day13.Layer(depth, range);
      }

      
      @NotNull
      public static Day13.Layer copy$default(Day13.Layer var0, int var1, int var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.depth;
         }

         if ((var3 & 2) != 0) {
            var2 = var0.range;
         }

         return var0.copy(var1, var2);
      }

      public String toString() {
         return "Layer(depth=" + this.depth + ", range=" + this.range + ")";
      }

      public int hashCode() {
         return this.depth * 31 + this.range;
      }

      public boolean equals(Object var1) {
         if (this != var1) {
            if (var1 instanceof Day13.Layer) {
               Day13.Layer var2 = (Day13.Layer)var1;
               if (this.depth == var2.depth && this.range == var2.range) {
                  return true;
               }
            }

            return false;
         } else {
            return true;
         }
      }
   }
}
