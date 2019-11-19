
<template>
  <svg width="700" height="700" />
</template>
<script>
//const d3 = require('d3');
import * as d3 from "d3";

export default {
  props: ["data"],
  watch: {
    data: function(newData) {
      this.drawChart(newData);
    }
  },
  methods: {
    drawChart: function(data) {
      var angleGen = d3
        .pie()
        .value(d => d.count)
        .sortValues((a, b) => (a < b ? 1 : -1));
      var arcs = angleGen(data);

      var block = this.pieG.selectAll(".arc").data(arcs);
      block.select("path").attr("d", this.arc);
      var newBlock = block
        .enter()
        .append("g")
        .classed("arc", true);
      var colorScale = d3
        .scaleSequential(d3.interpolate("purple", "orange"))
        .domain([1, 4]);
      newBlock
        .append("path")
        .attr("d", this.arc)
        .attr("id", function(d, i) {
          return "arc-" + i;
        })
        .attr("stroke", "gray")
        .attr("fill", d => colorScale(d.value));
      newBlock
        .append("text")
        .attr("dx", 70)
        .attr("dy", -5)
        .append("textPath")
        .attr("xlink:href", function(d, i) {
          return "#arc-" + i;
        })
        .text(function(d) {
          return d.data.name + "-" + d.data.dept_id;
        });
    }
  },
  mounted: function() {
    var svg = d3.select(this.$el);
    var width = +svg.attr("width");
    var height = +svg.attr("height");
    var margin = { top: 20, left: 0, bottom: 30, right: 0 };
    var chartWidth = width - (margin.left + margin.right);
    var chartHeight = height - (margin.top + margin.bottom);
    this.chartLayer = svg
      .append("g")
      .attr("transform", `translate(${margin.left}, ${margin.top})`);
    this.arc = d3
      .arc()
      .outerRadius(chartHeight / 2.5)
      .innerRadius(chartHeight / 5)
      .padAngle(0.03)
      .cornerRadius(8);
    this.pieG = this.chartLayer
      .append("g")
      .attr("transform", `translate(${chartWidth / 2}, ${chartHeight / 2})`);
    this.drawChart(this.data);
  }
};
</script>
<style scoped>
svg {
  background-color: rgb(152, 140, 221);
}
</style>>
