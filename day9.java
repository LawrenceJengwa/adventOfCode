package com.example.android.weather;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

// copyright (c) Lawrence Jengwa 2018
//Advent of code day 9 code

)
public final class day9 {
  
   public static final class Day9 {
      private final Regex cancel;
      private final Regex garbage;
      private final Regex nonGroup;
      private final String cleanInput;
      private final String input;

      public final int solvePart1() {
         CharSequence var1 = (CharSequence)this.cleanInput;
         Regex var2 = this.garbage;
         String var3 = "";
         String var5 = var2.replace(var1, var3);
         var1 = (CharSequence)var5;
         var2 = this.nonGroup;
         var3 = "";
         var5 = var2.replace(var1, var3);
         return scoreGroups$default(this, StringsKt.toList((CharSequence)var5), 0, 0, 6, (Object)null);
      }

      public final int solvePart2() {
         Sequence $receiver$iv = Regex.findAll$default(this.garbage, (CharSequence)this.cleanInput, 0, 2, (Object)null);
         int sum$iv = 0;

         int var9;
         for(Iterator var3 = $receiver$iv.iterator(); var3.hasNext(); sum$iv += var9) {
            Object element$iv = var3.next();
            MatchResult it = (MatchResult)element$iv;
            var9 = it.getValue().length() - 2;
         }

         return sum$iv;
      }

      private final int scoreGroups(List stream, int score, int depth) {
         while(!stream.isEmpty()) {
            List var10000;
            if ((Character)CollectionsKt.first(stream) == '}') {
               var10000 = CollectionsKt.drop((Iterable)stream, 1);
               --depth;
               stream = var10000;
            } else {
               var10000 = CollectionsKt.drop((Iterable)stream, 1);
               int var10001 = score + depth;
               ++depth;
               score = var10001;
               stream = var10000;
            }
         }

         return score;
      }

      
      static int scoreGroups$default(day9.Day9 var0, List var1, int var2, int var3, int var4, Object var5) {
         if ((var4 & 2) != 0) {
            var2 = 0;
         }

         if ((var4 & 4) != 0) {
            var3 = 1;
         }

         return var0.scoreGroups(var1, var2, var3);
      }

      public Day9(@NotNull String input) {
         Intrinsics.checkParameterIsNotNull(input, "input");
         super();
         this.input = input;
         String var2 = "!.";
         Regex var6 = new Regex(var2);
         this.cancel = var6;
         var2 = "<.*?>";
         var6 = new Regex(var2);
         this.garbage = var6;
         var2 = "[^{}]";
         var6 = new Regex(var2);
         this.nonGroup = var6;
         CharSequence var8 = (CharSequence)this.input;
         Regex var3 = this.cancel;
         String var4 = "";
         String var7 = var3.replace(var8, var4);
         this.cleanInput = var7;
      }
   }
}
